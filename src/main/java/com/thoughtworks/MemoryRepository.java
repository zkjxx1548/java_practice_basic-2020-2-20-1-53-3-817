package com.thoughtworks;

import java.util.*;

public class MemoryRepository implements Repository<Student> {
    private Map<String, Student> students = new HashMap<>();

    public MemoryRepository() {
    }

    public MemoryRepository(Map<String, Student> students) {
        this.students = students;
    }

    @Override
    public void save(String id, Student entity) {
        students.put(id, entity);
    }

    @Override
    public Student get(String id) {
        return students.get(id);
    }

    @Override
    public void delete(String id) {
        students.remove(id);
    }

    @Override
    public void update(String id, Student entity) {
        students.put(id, entity);
    }

    @Override
    public List<Student> list() {
        List<Student> list = new ArrayList<>();
        Set<Map.Entry<String, Student>> set = students.entrySet();
        Iterator<Map.Entry<String, Student>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Student> entry = it.next();
            list.add(entry.getValue());
        }
        return list;
    }
}
