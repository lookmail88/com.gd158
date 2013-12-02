package com.gd158.Dao;

import java.util.List;

public interface IGenericDAO <T>{
     
        
        void insert(T t);  
      
        void delete(T t);  
      
        void update(T t);  
      
        T queryById(String id);  
      
        List<T> queryAll();  
        
        List<T> queryPage(String pageno,String pagesize);
 
}
