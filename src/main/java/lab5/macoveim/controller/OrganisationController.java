package lab5.macoveim.controller;

import lab5.macoveim.model.Employee;
import lab5.macoveim.model.Organisation;
import lab5.macoveim.model.Product;
import lab5.macoveim.repository.EmployeeRepository;
import lab5.macoveim.repository.OrganisationRepository;
import lab5.macoveim.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisations")
public class OrganisationController {
    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Organisation> findAll() {
        return organisationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Organisation findById(@PathVariable long id) {
        return organisationRepository.findById(id);
    }

    @GetMapping("/{id}/employee")
    public List<Employee> findOrganizationProduct(@PathVariable long id) {
        return employeeRepository.findByOrgId(id);
    }

    @GetMapping("/{id}/product")
    public List<Product> findOrganizationEmployee(@PathVariable long id) { return productRepository.findByOrgId(id); }

    @PostMapping
    public void save(@RequestBody Organisation organisation) {
        organisationRepository.save(organisation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        organisationRepository.delete(id);
    }

    @PutMapping
    public void update(@RequestBody Organisation organisation) {
        organisationRepository.update(organisation);
    }
}
