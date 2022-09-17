package restStandard2.restStandard2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restStandard2.restStandard2.domain.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    //== 이메일로 찾기 ==//
    Users findByEmail(String email);
}
