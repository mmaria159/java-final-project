package lab5.macoveim.repository;

import lab5.macoveim.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganisationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Organisation> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM organisation ",
                (response, rowNumber) ->
                        new Organisation(response.getInt("id_organisation"),
                                response.getString("org_name"),
                                response.getString("street"),
                                response.getLong("telephone")));
    }

    public void save(Organisation organisation) {
        jdbcTemplate.update(
                "INSERT INTO organisation(org_name,street,telephone) VALUES(?,?,?)",
                organisation.getName(), organisation.getStreet(), organisation.getTelephone());

    }

    public Organisation findById(long organizationId) {
        return jdbcTemplate.queryForObject("SELECT *FROM  organisation WHERE id_organisation=?", new Object[]{organizationId},
                (response, rowNum) -> {
                    return new Organisation(response.getInt("id_organisation"),
                            response.getString("org_name"),
                            response.getString("street"),
                            response.getLong("telephone"));
                });
    }

    public void delete(long id_organisation) {
        jdbcTemplate.update("DELETE FROM organisation WHERE id_organisation= ?", id_organisation);
    }

    public void update(Organisation organisation) {
        jdbcTemplate.update("UPDATE organisation SET org_name= ? , street= ? , telephone= ?  WHERE id_organisation= ?",
                organisation.getName(), organisation.getStreet(), organisation.getTelephone(), organisation.getId());
    }


}
