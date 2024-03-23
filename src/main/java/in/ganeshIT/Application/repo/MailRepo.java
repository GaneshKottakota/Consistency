package in.ganeshIT.Application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ganeshIT.Application.entity.User;

public interface MailRepo extends JpaRepository<User, Integer> {
	public User findByEmailAndPwd(String email,String pwd);
	public User findByEmail(String email);

}
