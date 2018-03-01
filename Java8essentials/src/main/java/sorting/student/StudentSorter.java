package sorting.student;

import java.util.*;

/**
 You are given a list of student information: ID, FirstName, and CGPA.
 Your task is to rearrange them according to their CGPA in decreasing order.
 If two student have the same CGPA, then arrange them according to their first name in alphabetical order.
 If those two students also have the same first name,
 then order them according to their ID. No two students have the same ID.
 */
public class StudentSorter {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        sortWithComparator( studentList );

        studentList.stream().forEach( s -> { System.out.println(s.getFname()); } );

    }

    public static void sortWithComparator( List<Student> studentList ) {
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student a, Student b) {
                double cgpaDiff = b.getCgpa() - a.getCgpa();
                int result = cgpaDiff > 0 ? 1 : cgpaDiff == 0 ? 0 : -1;
                if (result == 0) {
                    result = a.getFname().compareTo(b.getFname());
                    if (result == 0) {
                        result = b.getId() - a.getId();
                    }
                }
                return result;
            }
        });
    }
}
