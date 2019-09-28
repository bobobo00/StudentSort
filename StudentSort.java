package TestCompare;

import java.util.Comparator;

/**
 * @ClassName StudentSort
 * @Description TODO
 * @Auther danni
 * @Date 2019/9/28 16:06]
 * @Version 1.0
 **/

public class StudentSort {
    //comparableto方法
    public static void studentSort(Student[] stu){
        for (int i = 1; i <stu.length ; i++) {
            Student s=stu[i];
            int j=i-1;
            for (j = i-1; j>=0&&(stu[j].compareTo(s))>0 ; j--) {
                stu[j+1]=stu[j];
            }
            stu[j+1]=s;
        }
    }
    //comparator方法
    public static void studentSort(Student[] stu, Comparator<Student> cmp){

        for (int i = 1; i <stu.length ; i++) {
            Student s=stu[i];
            int j=i-1;
            for (j = i-1; j>=0&&(cmp.compare(stu[j],s))>0 ; j--) {
                stu[j + 1] = stu[j];
            }
            stu[j+1]=s;
        }
    }

    public static void main(String[] args) {
        StudentSort studentSort=new StudentSort();
        Student[] students={new Student("a",18,164),
                new Student("a",15,170),
                new Student("c",20,175)};
        Comparator comparator=new StudentComparator();
        studentSort(students,comparator);
        for(Student stu:students){
            System.out.println(stu);
        }


    }
}
class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.name.compareTo(o2.name)!=0){
            return o1.name.compareTo(o2.name);
        }else if(o1.age-o2.age!=0){
            return o1.age-o2.age;
        }else{
            return o1.height-o2.height;
        }
    }
}

