package com.wyx.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wyx.module.CollegeInfo;
import com.wyx.module.CollegeSort;
import com.wyx.module.EventSort;
import com.wyx.module.StudentInfo;
import com.wyx.module.SystemInfo;

/**
 * Class Name:Data.java
 * 
 * @Description 数据存放
 * @author GPZoe
 * @data 2019年12月27日
 * @version 1.0 
 */
public class Data {
	
	/**
	 * Description:学院管理员信息
	 */
	public static Map<String,CollegeInfo> collegeData = new HashMap<>();
	
	/**
	 * Description:系统管理员信息
	 */
	public static Map<String,SystemInfo> systemData= new HashMap<>();
	
	/**
	 * Description:运动员信息
	 */
	public static Map<String,List<StudentInfo>> studentData= new HashMap<>();
	
	/**
	 * Description:赛事信息
	 */
	public static Map<String,List<EventSort>> eventSortData= new HashMap<>();
	
	/**
	 * Description:按学院划分的信息
	 */
	public static Map<String,List<CollegeSort>> collegeSortData= new HashMap<>();
	
	
	static {
		InitCollegeInfo();
		InitSystemInfo();
		InitStudentInfo();
		InitCollegeSort();
		InitEventSort();
	}
	

	/**
	 * Description：学院管理员信息
	 * @return void
	 * @data 2019年12月27日
	 */
	public static void InitCollegeInfo() {
		CollegeInfo collegeinfo1 = new CollegeInfo("2018","2018","135235235235","医学院");
		CollegeInfo collegeinfo2 = new CollegeInfo("2017","2017","198198198198","法学院");
		collegeData.put(collegeinfo1.getAccount(), collegeinfo1);
		collegeData.put(collegeinfo2.getAccount(), collegeinfo2);
		
	}
	
	/**
	 * Description：系统管理员信息
	 * @return void
	 * @data 2019年12月27日
	 */
	public static void InitSystemInfo() {
		SystemInfo systeminfo1 = new SystemInfo("admin","admin","135235235235","暂无备注信息");
		systemData.put(systeminfo1.getAccount(), systeminfo1);
	}
	
	/**
	 * Description：按学院划分的hashmap - hashmap对象是一个列表，存储同学院的信息
	 * @return void
	 * @data 2019年12月27日
	 */
	public static void InitCollegeSort() {
		
		CollegeSort collegesort0 = new CollegeSort("2017001","姓名一","医学院","男子200米","未登记");
		CollegeSort collegesort1 = new CollegeSort("2017001","姓名一","医学院","男子100米","未登记");		//一人多项
		CollegeSort collegesort2 = new CollegeSort("2017003","姓名二","医学院","男子400米","未登记");		//一项多人
		CollegeSort collegesort3 = new CollegeSort("2018001","姓名三","医学院","男子400米","未登记");
		CollegeSort collegesort4 = new CollegeSort("2018002","姓名四","医学院","男子跳远","未登记");		//跨院同项
		CollegeSort collegesort5 = new CollegeSort("2018005","姓名五","医学院","男子1500米","1");

		CollegeSort collegesort6 = new CollegeSort("2017005","姓名六","法学院","男子跳远","未登记");
		CollegeSort collegesort7 = new CollegeSort("2017006","姓名七","法学院","女子跳高","未登记");
		CollegeSort collegesort8 = new CollegeSort("2017007","姓名八","法学院","女子铅球","6");
		
		ArrayList<CollegeSort> list1 = new ArrayList<>();
		list1.add(collegesort0);
		list1.add(collegesort1);	
		list1.add(collegesort2);
		list1.add(collegesort3);
		list1.add(collegesort4);
		list1.add(collegesort5);
		collegeSortData.put("医学院", list1);
		
		ArrayList<CollegeSort> list2 = new ArrayList<>();
		list2.add(collegesort6);
		list2.add(collegesort7);
		list2.add(collegesort8);
		collegeSortData.put("法学院", list2);
	}
	
	/**
	 * Description：按项目划分的hashmap - hashmap中对象是列表，存储同项目的信息
	 * @return void
	 * @data 2019年12月27日
	 */
	public static void InitEventSort() {
		EventSort eventsort0 = new EventSort("2017001","姓名一","医学院","男子200米","未登记");
		EventSort eventsort1 = new EventSort("2017001","姓名一","医学院","男子100米","未登记");//一人多项
		EventSort eventsort2 = new EventSort("2017003","姓名二","医学院","男子400米","未登记");//一项多人
		EventSort eventsort3 = new EventSort("2018001","姓名三","医学院","男子400米","未登记");
		EventSort eventsort4 = new EventSort("2018002","姓名四","医学院","男子跳远","未登记");//跨院同项
		EventSort eventsort5 = new EventSort("2018005","姓名五","医学院","男子1500米","1");

		EventSort eventsort6 = new EventSort("2017005","姓名六","法学院","男子跳远","未登记");
		EventSort eventsort7 = new EventSort("2017006","姓名七","法学院","女子跳高","未登记");
		EventSort eventsort8 = new EventSort("2017007","姓名八","法学院","女子铅球","6");
		
		
		ArrayList<EventSort> list1 = new ArrayList<>();
		list1.add(eventsort0);	
		eventSortData.put("男子200米", list1);
		
		ArrayList<EventSort> list2 = new ArrayList<>();
		list2.add(eventsort1);	
		eventSortData.put("男子100米", list2);
		
		ArrayList<EventSort> list3 = new ArrayList<>();
		list3.add(eventsort2);	
		list3.add(eventsort3);	
		eventSortData.put("男子400米", list3);
		
		ArrayList<EventSort> list4 = new ArrayList<>();
		list4.add(eventsort4);	
		list4.add(eventsort6);	
		eventSortData.put("男子跳远", list4);
		
		ArrayList<EventSort> list5 = new ArrayList<>();
		list5.add(eventsort5);	
		eventSortData.put("男子4*100米接力", list5);
		
		ArrayList<EventSort> list6 = new ArrayList<>();
		list6.add(eventsort7);	
		eventSortData.put("女子跳高", list6);
		
		ArrayList<EventSort> list7 = new ArrayList<>();
		list7.add(eventsort8);	
		eventSortData.put("女子铅球", list7);
		
		
		
	}
	
	/**
	 * Description：运动员信息
	 * @return void
	 * @data 2019年12月27日
	 */
	public static void InitStudentInfo() {
		StudentInfo studentinfo0 = new StudentInfo("2017001","姓名一","医学院","男子200米","未登记");
		StudentInfo studentinfo1 = new StudentInfo("2017001","姓名一","医学院","男子100米","未登记");		//一人多项
		StudentInfo studentinfo2 = new StudentInfo("2017003","姓名二","医学院","男子400米","未登记");		//一项多人
		StudentInfo studentinfo3 = new StudentInfo("2018001","姓名三","医学院","男子400米","未登记");
		StudentInfo studentinfo4 = new StudentInfo("2018002","姓名四","医学院","男子跳远","未登记");		//跨院同项
		StudentInfo studentinfo5 = new StudentInfo("2018005","姓名五","医学院","男子1500米","1");

		StudentInfo studentinfo6 = new StudentInfo("2017005","姓名六","法学院","男子跳远","未登记");
		StudentInfo studentinfo7 = new StudentInfo("2017006","姓名七","法学院","女子跳高","未登记");
		StudentInfo studentinfo8 = new StudentInfo("2017007","姓名八","法学院","女子铅球","6");
		
		ArrayList<StudentInfo> list1 = new ArrayList<>();
		list1.add(studentinfo0);
		list1.add(studentinfo1);
		studentData.put(studentinfo1.getId(), list1);
		
		ArrayList<StudentInfo> list2 = new ArrayList<>();
		list2.add(studentinfo2);
		studentData.put(studentinfo2.getId(), list2);
		ArrayList<StudentInfo> list3 = new ArrayList<>();
		list3.add(studentinfo3);
		studentData.put(studentinfo3.getId(), list3);
		ArrayList<StudentInfo> list4 = new ArrayList<>();
		list4.add(studentinfo4);
		studentData.put(studentinfo4.getId(), list4);
		ArrayList<StudentInfo> list5 = new ArrayList<>();
		list5.add(studentinfo5);
		studentData.put(studentinfo5.getId(), list5);
		ArrayList<StudentInfo> list6 = new ArrayList<>();
		list6.add(studentinfo6);
		studentData.put(studentinfo6.getId(), list6);
		ArrayList<StudentInfo> list7 = new ArrayList<>();
		list7.add(studentinfo7);
		studentData.put(studentinfo7.getId(), list7);
		ArrayList<StudentInfo> list8 = new ArrayList<>();
		list8.add(studentinfo8);
		studentData.put(studentinfo8.getId(), list8);
	}
	
}
