package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

class BishopBlackTest {

    @Test
    public void whenPositionTheSame() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Cell result = bishop.position();
        assertThat(result).isEqualTo(Cell.C8);
    }

    @Test
    public void whenCopy() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Figure copy = bishop.copy(Cell.F5);
        assertThat(copy.position()).isEqualTo(Cell.F5);
    }

    @Test
    public void whenWayFromF8ToB4() {
        BishopBlack bishop = new BishopBlack(Cell.F8);
        Cell[] result = bishop.way(Cell.B4);
        Cell[] expected = {
                Cell.E7,
                Cell.D6,
                Cell.C5,
                Cell.B4
        };
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenWayFromC1ToG5() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] result = bishop.way(Cell.G5);
        Cell[] expected = {
                Cell.D2,
                Cell.E3,
                Cell.F4,
                Cell.G5
        };
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenWayNoDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThrows(
                ImpossibleMoveException.class,
                () -> bishop.way(Cell.C2)
        );
    }
}