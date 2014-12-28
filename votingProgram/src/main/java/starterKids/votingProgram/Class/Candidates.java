package starterKids.votingProgram.Class;

import javax.persistence.Entity;

import org.hibernate.annotations.Table;


@Entity
@Table (name = "candidates")
public class Candidates {
	
	@Id
	@GeneratedValue @Column (name="id")
	private int id;
	
	@Column(name="firsname")
	private String firsname;
	@Column (name="surname")
	private String surname;
	@Column (name = "zip_codes_id")
	private int zip_codes_id;
	
}
