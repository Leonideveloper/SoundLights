package com.gmail.leonidandand.soundlights.mvc.model.randomizers;

import com.gmail.leonidandand.soundlights.utils.Dimension;
import com.gmail.leonidandand.soundlights.utils.Matrix;

/**
 * Created by Leonid on 12.07.13.
 */
public class PositionRandomizer {

    private Matrix.Position prevPosition = null;

    public Matrix.Position randomPosition(Dimension dim) {
        int row = Randomizer.randomPositiveInt() % dim.rows;
        int column = Randomizer.randomPositiveInt() % dim.columns;
        return new Matrix.Position(row, column);
    }

    private synchronized Matrix.Position nextPosition(Dimension dim) {
        Matrix.Position next =
                prevPosition == null
                        ? new Matrix.Position(0, 0)
                        : nextPosition(prevPosition, dim);
        prevPosition = next;
        return next;
    }

    private Matrix.Position nextPosition(Matrix.Position prevPosition, Dimension dim) {
        int column = prevPosition.column + 1;
        int row = prevPosition.row;
        if (column >= dim.columns) {
            column = 0;
            ++row;
            if (row >= dim.rows) {
                row = 0;
            }
        }
        return new Matrix.Position(row, column);
    }
}
