package week6.BOJ_1713_실버1_후보선택하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Student> frame = new ArrayList<>();
        Student[] students = new Student[101];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int id = Integer.parseInt(st.nextToken());

            if (students[id] != null) {
                students[id].count++;
            } else {
                if (frame.size() < N) {
                    Student student = new Student(id, 1, i);
                    frame.add(student);
                    students[id] = student;
                } else if (frame.size() == N) {
                    frame.sort((o1, o2) -> {
                        if (o1.count != o2.count) {
                            return o1.count - o2.count;
                        }
                        return o1.uploadedAt - o2.uploadedAt;
                    });
                    Student toRemove = frame.get(0); // 가장 먼저 제거할 학생
                    frame.remove(0);
                    students[toRemove.id] = null;

                    Student student = new Student(id, 1, i);
                    frame.add(student);
                    students[id] = student;
                }
            }
        }

        frame.sort(Comparator.comparingInt(o -> o.id));
        for (Student student : frame) {
            bw.write(student.id + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Student {

        int id;
        int count;
        int uploadedAt;

        public Student(int id, int count, int uploadedAt) {
            this.id = id;
            this.count = count;
            this.uploadedAt = uploadedAt;
        }
    }
}
