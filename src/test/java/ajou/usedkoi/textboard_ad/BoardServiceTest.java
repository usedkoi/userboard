package ajou.usedkoi.textboard_ad;

import ajou.usedkoi.textboard_ad.Entity.Board;
import ajou.usedkoi.textboard_ad.Repository.BoardRepository;
import ajou.usedkoi.textboard_ad.Service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    @Test
    public void getAllBoardsTest() {
        // 가짜 데이터 설정
        Board board1 = new Board("이름", "주소", 1998,"01000020001");
        Board board2 = new Board("위름", "쥬소", 1941,"02000023001");
        when(boardRepository.findAll()).thenReturn(Arrays.asList(board1, board2));

        // 서비스 메서드 호출
        List<Board> boards = boardService.getAllBoards();

        // 검증
        assertThat(boards).hasSize(2);
        verify(boardRepository, times(1)).findAll();
    }

    @Test
    public void saveBoardTest() {
        // 가짜 데이터 설정
        Board board = new Board("이름", "주소", 1998,"01000020001");
        when(boardRepository.save(board)).thenReturn(board);

        // 서비스 메서드 호출
        Board savedBoard = boardService.saveBoard(board);

        // 검증
        assertThat(savedBoard.getName()).isEqualTo("이름");
        assertThat(savedBoard.getAddr()).isEqualTo("주소");
        assertThat(savedBoard.getBirthday()).isEqualTo(1998);
        assertThat(savedBoard.getMobile()).isEqualTo("01000020001");
        verify(boardRepository, times(1)).save(board);
    }

    @Test
    public void getBoardByIdTest() {
        // 가짜 데이터 설정
        Board board = new Board("이름", "주소", 1998,"01000020001");
        when(boardRepository.findById(1L)).thenReturn(Optional.of(board));

        // 서비스 메서드 호출
        Board foundBoard = boardService.getBoardById(1L);

        // 검증
        assertThat(foundBoard).isNotNull();
        assertThat(foundBoard.getName()).isEqualTo("이름");
        assertThat(foundBoard.getAddr()).isEqualTo("주소");
        assertThat(foundBoard.getBirthday()).isEqualTo(1998);
        assertThat(foundBoard.getMobile()).isEqualTo("01000020001");
        verify(boardRepository, times(1)).findById(1L);
    }

    @Test
    public void deleteBoardTest() {
        // 서비스 메서드 호출
        boardService.deleteBoard(1L);

        // 검증
        verify(boardRepository, times(1)).deleteById(1L);
    }
}
