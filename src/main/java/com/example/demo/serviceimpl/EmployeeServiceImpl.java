package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		else
		{
			throw new ResourceNotFoundException("Employee ", "Id", id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee ", "Id", id));
		existingEmployee.setName(employee.getName());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id", id));
		employeeRepository.deleteById(id);
		
	}

}
