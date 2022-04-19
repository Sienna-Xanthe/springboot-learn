package com.kuang.mapper;

import com.kuang.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface employeeMapper {

    //增加一个员工
    public void save(Employee employee);

    //查询全部员工信息
    public Collection<Employee> getAll();

    //通过id查询员工
    public Employee getEmployeeById(Integer id);

    //删除员工通过id
    public void delete(Integer id);
}
