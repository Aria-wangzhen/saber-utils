import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangzhen on 2017/6/5.
 */
public class TestClone {

    private static class Student implements Cloneable {
        private String name;
        private int age;
        private String unique;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public Student(String name, int age, String unique) {
            this.name = name;
            this.age = age;
            this.unique = unique;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getUnique() {
            return unique;
        }

        public void setUnique(String unique) {
            this.unique = unique;
        }

        public Object clone() {
            Student o = null;
            try {
                o = (Student) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return o;
        }
    }

    public static void main(String[] args) {

        Student student = new Student("wangzhen", 12, "123");
        Student student1 = new Student("wangzhen", 14, "456");
        Student student3 = new Student("xudanfeng", 12, "789");
        List<Student> list = new ArrayList<Student>();
        list.add(student);
        list.add(student1);
        list.add(student3);

        List<Student> listCopy = new ArrayList<Student>();
        listCopy.addAll(list);


        Iterator<Student> poCopyItor = list.iterator();
        while (poCopyItor.hasNext()) {
            Student pos = poCopyItor.next();
            Iterator<Student> poItor = list.iterator();
            while (poItor.hasNext()) {
                Student po = poItor.next();
                if (po.getUnique().equals(pos.getUnique())) {
                    poItor.remove();
                }
                if (po.getName().trim().equals(pos.getName().trim()) &&
                        !po.getUnique().equals(pos.getUnique())) {
                    pos.setAge(pos.getAge() + po.getAge());

                    poItor.remove();
                    listCopy.remove(po);
                }
            }

        }

        for (Student s : listCopy) {
            System.out.println(s.getAge());
        }


    }


}

