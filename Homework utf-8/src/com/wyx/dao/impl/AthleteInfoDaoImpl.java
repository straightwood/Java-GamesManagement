package com.wyx.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.wyx.dao.AthleteInfoDao;
import com.wyx.module.CollegeInfo;
import com.wyx.module.CollegeSort;
import com.wyx.module.EventSort;
import com.wyx.module.StudentInfo;
import com.wyx.util.CommonNumber;
import com.wyx.util.Data;

public class AthleteInfoDaoImpl implements AthleteInfoDao{
	
	public static Map<String, List<StudentInfo>> athleteData = Data.studentData;
	public static Map<String, CollegeInfo> collegeData = Data.collegeData;
	public static Map<String, List<CollegeSort>> collegesortData = Data.collegeSortData;
	public static Map<String, List<EventSort>> eventsortData = Data.eventSortData;
	
	@Override
	public List<CollegeSort> showAthleteList(String account) {
//		System.out.println(collegeData.get(account).getOther());
		return collegesortData.get(collegeData.get(account).getOther());
	}
	
	@Override
	public boolean addAthleteInfo(StudentInfo info,String account) {
		
		List<StudentInfo> sl = athleteData.get(info.getId());
		boolean flag = true;		//项目验重标记
		
		if(sl!=null && sl.size()!=0) {				//若该学生已报名过其他项目，同步其姓名，学院默认为管理员所属学院
			StudentInfo student = sl.get(0);
			info.setName(student.getName());
			for(StudentInfo s :sl) {
				if(s.getEvent().equals(info.getEvent())) {		//通过学号与项目来查看报名信息是否已存在
					flag = false;
				}
			}
			if(flag) {
				info.setCollege(student.getCollege());
				athleteData.get(info.getId()).add(info);
				
				//个人信息存在college一定存在
				CollegeSort collegesort = new CollegeSort();
				collegesort.setId(info.getId());
				collegesort.setName(info.getName());
				collegesort.setCollege(info.getCollege());
				collegesort.setEvent(info.getEvent());
				collegesort.setScore("");
				collegesortData.get(info.getCollege()).add(collegesort);
				
				//个人信息存在event有可能不存在
				EventSort eventsort = new EventSort();
				eventsort.setId(info.getId());
				eventsort.setName(info.getName());
				eventsort.setCollege(info.getCollege());
				eventsort.setEvent(info.getEvent());
				eventsort.setScore("");
				
				List<EventSort> el = eventsortData.get(info.getCollege());
				if(el!=null && el.size()!=0) {
					EventSort event = el.get(0);
					info.setName(event.getName());
					info.setCollege(event.getCollege());
					eventsortData.get(info.getEvent()).add(eventsort);
					
				}else {
					List<EventSort> list = new ArrayList<>();
					list.add(eventsort);
					eventsortData.put(info.getEvent(),list);
				}
			}

		}else {												//若该学生从未报名过，学院默认管理员所在学院
			List<StudentInfo> list = new ArrayList<>();
			info.setCollege(collegeData.get(account).getOther());
			list.add(info);
			athleteData.put(info.getId(),list);
			
			CollegeSort collegesort = new CollegeSort();
			collegesort.setId(info.getId());
			collegesort.setName(info.getName());
			collegesort.setCollege(info.getCollege());
			collegesort.setEvent(info.getEvent());
			collegesort.setScore("");
			collegesortData.get(info.getCollege()).add(collegesort);
			
			EventSort eventsort = new EventSort();
			eventsort.setId(info.getId());
			eventsort.setName(info.getName());
			eventsort.setCollege(info.getCollege());
			eventsort.setEvent(info.getEvent());
			eventsort.setScore("");
			
			List<EventSort> el = eventsortData.get(info.getCollege());
			if(el!=null && el.size()!=0) {
				EventSort event = el.get(0);
				info.setName(event.getName());
				info.setCollege(event.getCollege());
				eventsortData.get(info.getEvent()).add(eventsort);
				
			}else {
				List<EventSort> lis = new ArrayList<>();
				lis.add(eventsort);
				eventsortData.put(info.getEvent(),lis);
			}
			
		}
		return flag;
	}

	@Override
	public List<StudentInfo> searchAthleteInfo(StudentInfo info,String account) {
		List<StudentInfo> athlete = athleteData.get(info.getId());
		List<StudentInfo> getInfo = new ArrayList<>();
		if(athlete!=null && athlete.size()!=0) {
			for(StudentInfo s :athlete) {
				if(s.getCollege().equals(collegeData.get(account).getOther())) {
					getInfo.add(s);
				}
			}
		}
		return getInfo;
	}
	
	@Override
	public List<StudentInfo> searchAthleteInfoBySystem(StudentInfo info) {
		return athleteData.get(info.getId());
	}

	@Override
	public boolean editAthleteInfo(StudentInfo info, String flag, String num,String newInfo) {
		List<StudentInfo> l =athleteData.get(info.getId());
		StudentInfo s = l.get(Integer.parseInt(flag)-1);
		boolean MARK = false;
		if(num.equals(CommonNumber.MODIFY_NAME)) {
			for(StudentInfo e:l) {
				e.setName(newInfo);
				
				//对event，多次用event取到列表，然后匹配学号，改掉姓名
				List<EventSort> el = eventsortData.get(info.getEvent());
				//System.out.println(info.getEvent());
				if(el!=null && el.size()!=0) {
					for(EventSort event:el) {
						if(event.getId().equals(info.getId())) {
							event.setName(newInfo);
						}
					}
				}
			}
			//college来说，单次用college取到，匹配学号，改掉姓名
			List<CollegeSort> sl = collegesortData.get(info.getCollege());
			if(sl!=null && sl.size()!=0) {
				for(CollegeSort college:sl) {
					if(college.getId().equals(info.getId())) {
						college.setName(newInfo);
					}
				}
			}
			MARK = true;
		}
		if(num.equals(CommonNumber.MODIFY_EVENT)) {
			s.setEvent(newInfo);	
			//对college来说，用学号和项目匹配到，然后改掉项目
			List<CollegeSort> sl = collegesortData.get(info.getCollege());
			if(sl!=null && sl.size()!=0) {
				for(CollegeSort college:sl) {
					if(college.getEvent().equals(info.getEvent()) && college.getId().equals(info.getId())) {
						college.setEvent(newInfo);
					}
				}
			}
			//对event来说，新开一个key放入，或者添加到原有的key里， 并且要删除原有的
			EventSort event = new EventSort();//新建一个EventSort对象
			event.setId(info.getId());
			event.setName(info.getName());
			event.setCollege(info.getCollege());
			event.setEvent(info.getEvent());
			event.setScore(info.getGrade());
			
			List<EventSort> el = eventsortData.get(newInfo);
			if(el!=null && el.size()!=0) {			//如果原来人报名没有这个项目
				el.add(event);	
			}else {					//已经有报名的人了
				List<EventSort> newkey = new ArrayList<>();
				newkey.add(event);
				eventsortData.put(newInfo,newkey);					
			}
			//删除原有的event
			List<EventSort> elold = eventsortData.get(info.getEvent());
			//迭代器删除
			Iterator<EventSort> iter = elold.iterator();
			while(iter.hasNext()){//判断集合有没有下一个元素，从-1开始
				EventSort del = iter.next();
				if(del.getId().equals(info.getId())) {
					iter.remove();
				}
			}
			MARK = true;
		}
		return MARK;
	}

	@Override
	public boolean deleteAthleteInfo(StudentInfo info,String flag) {
		List<StudentInfo> l = athleteData.get(info.getId());
		
		if(l.size()>=Integer.parseInt(flag)) {
			StudentInfo target= l.get(Integer.parseInt(flag)-1);
			l.remove(Integer.parseInt(flag)-1);
			//System.out.println(l.get(0).toString());
			
			//college来说 用项目和学号匹配
			List<CollegeSort> sl = collegesortData.get(target.getCollege());
			//迭代器删除
			Iterator<CollegeSort> iter = sl.iterator();
			while(iter.hasNext()){//判断集合有没有下一个元素，从-1开始
				CollegeSort college = iter.next();
				
				if(college.getEvent().equals(target.getEvent()) && college.getId().equals(target.getId())) {
					iter.remove();
				}
			}
			
			//event用学号匹配
			List<EventSort> el = eventsortData.get(target.getEvent());
			//迭代器删除
			Iterator<EventSort> iterr = el.iterator();
			while(iterr.hasNext()){//判断集合有没有下一个元素，从-1开始
				EventSort event = iterr.next();
				if(event.getId().equals(target.getId())) {
					iterr.remove();
					break;
				}
			}			
			//athleteData.remove(info.getId());    //这是啥？？？？？？？？？？？？？
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean isAthleteInfoExit(StudentInfo info) {
		return athleteData.get(info.getId()) != null;
	}

	

}
