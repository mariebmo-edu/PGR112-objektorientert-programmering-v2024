package service;

import repo.AbstractRepo;

import java.util.ArrayList;

public abstract class AbstractService<T> {

    private final AbstractRepo<T> repo;

    public AbstractService(AbstractRepo<T> repo){
        this.repo = repo;
    }

    public ArrayList<T> getAll(){
        return repo.getAll();
    }

    public T getById(int i){
        return repo.getById(i);
    }

    public void insert(T t){
        repo.insert(t);
    }

    public void insertList(ArrayList<T> list){
        for(T t : list){
            repo.insert(t);
        }
    }

    public boolean exists(T t){
        return repo.exists(t);
    }

    public boolean deleteById(int i){
        return repo.deleteById(i);
    }

    public boolean update(T t){
        return repo.update(t);
    }
}
