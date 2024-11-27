package ajou.usedkoi.textboard_ad.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String addr;
    private int birthday;
    private String mobile;

    // 생성자
    public Board(String name, String addr, int birthday, String mobile) {
        this.name = name;
        this.addr = addr;
        this.birthday = birthday;
        this.mobile = mobile;
    }
}
