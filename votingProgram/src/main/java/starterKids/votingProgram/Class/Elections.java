package starterKids.votingProgram.Class;

import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.Table;

@Entity
@Table (name = "elections")
public class Elections {

		@Id
		@GeneratedValue @Column (name="id")
		private int id;
		private Date election_date;
		private String type;
}
