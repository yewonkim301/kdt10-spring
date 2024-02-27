package codingon.condingonspringbootjpa.service;

import codingon.condingonspringbootjpa.dto.UserDTO;
import codingon.condingonspringbootjpa.entity.UserEntity;
import codingon.condingonspringbootjpa.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getUserList() {
        // repository 에서 전체 조회 가능하도록
        // findAll() JpaRepository 인터페이스에 정의도어 있는 메소드

        List<UserEntity> users = userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (UserEntity user: users) {
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .no(user.getId() + 100)
                    .name(user.getName())
                    .nickname(user.getNickname())
                    .build();
            result.add(userDTO);
        }
        return result;
    }

    public String insertUser(UserEntity user) {
        // jpa save(T) 메소드 : T 는 Entity
        // - insert 할 때
        // - 기존 entity 를 update 할 때
        // -> 기본값(pk) 상태에 따라 다르게 동작
        //      pk 가 존재한다면 pk 와 연결된 entity update
        //      pk 가 없는 경우, 새로운 entity insert

        UserEntity newUser = userRepository.save(user);
        // save 를 했을 때 반환되는 객체는 Entity 객체
        return newUser.getName();
    }

    public boolean checkUser(String name) {
        return userRepository.existsByName(name);
    }

    public List<UserEntity> findUser(String name) {
        return userRepository.findByName(name);
    }

    public List<UserEntity> findUserAll(String name, String nickname) {
        return userRepository.findByNameOrNickname(name, nickname);
    }

    // 해설
    /*
    public String searchId(int id) {
        Optional<UserEntity> result = userRepository.findById(id);

        // get() : Optional 내부에 담긴 객체 반환
        // - 만약 null 이라면 NoSuchElementException 발생
        // isPresent(): 객체의 여부를 boolean 값으로 반환
        // orElse() : 있으면 반환하고 없으면 다른 값 반환 (() 있는 설정된 값)
        // -orElse() : Optional.orElse();
        //  userRepository.findById(id).orElseThrow(() -> new RuntimeException("user dosent't exist"));

        if(result.isPresent()) {
            return result.get().getName();
        } else {
            return "no user";
        }
    }
    */
}
