package com.thoughtworks;

import java.util.*;

public class MemoryRepository<E> implements Repository<E> {
    private Map<String, E> map = new HashMap<>();

    public MemoryRepository() {
    }

    public MemoryRepository(Map<String, E> map) {
        this.map = map;
    }

    @Override
    public void save(String id, E entity) {
        if (map.containsKey(id)) {
            System.out.println("已存在该id的学生");
        } else {
            map.put(id, entity);
        }
    }

    @Override
    public E get(String id) {
        return map.get(id);
    }

    @Override
    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public void update(String id, E entity) {
        map.put(id, entity);
    }

    @Override
    public List<E> list() {
        List<E> list = new ArrayList<>();
        Set<Map.Entry<String, E>> set = map.entrySet();
        for (Map.Entry<String, E> entry : set) {
            list.add(entry.getValue());
        }
        return list;
    }
}
