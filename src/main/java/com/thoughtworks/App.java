package com.thoughtworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

  public static void main(String[] args) {
    MemoryRepository mr = new MemoryRepository();
    List<Student> list = new ArrayList<>();
    list.add(new Student("3", "张三"));
    list.add(new Student("4", "李四"));
    list.add(new Student("5", "王五"));
    list.add(new Student("6", "赵六"));
    list.add(new Student("7", "钱七"));

    for (Student student : list) {
      mr.save(student.getId(), student);
    }

    mr.get("3").toString();
    mr.delete("李四");
    mr.update("5", new Student("5", "冯五"));

    for (Student student : mr.list()) {
      RepositoryUtil.printList(student);
    }
  }
}
