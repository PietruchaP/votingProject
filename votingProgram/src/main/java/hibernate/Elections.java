package hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "elections")
public class Elections {

		@Id
		@GeneratedValue @Column (name="id")
		private int id;
		@Column (name ="election_date")
		private Date election_date;
		@Column (name = "type")
		private String type;
}
