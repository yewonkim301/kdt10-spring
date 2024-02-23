package codingon.condingonspringboot.vo;

import lombok.Getter;

import java.util.Objects;

@Getter
public class AxiosPracVO {
    private String name;
    private String gender;
    private String birthday;
    private String hobby;

    // 동등성 구현을 위한 코드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AxiosPracVO axiosPracVO = (AxiosPracVO) o;

        // 여기서 모든 필드를 비교
        return Objects.equals(name, axiosPracVO.name) && Objects.equals(gender, axiosPracVO.gender) && Objects.equals(birthday, axiosPracVO.birthday) && Objects.equals(hobby, axiosPracVO.hobby);
    }

    @Override
    public int hashCode() {
        // 필드들을 이용한 해시코드 생성
        return Objects.hash(name, gender, birthday, hobby);
    }
}
