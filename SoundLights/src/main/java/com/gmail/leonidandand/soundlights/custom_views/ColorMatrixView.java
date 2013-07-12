package com.gmail.leonidandand.soundlights.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gmail.leonidandand.soundlights.R;
import com.gmail.leonidandand.soundlights.utils.Dimension;
import com.gmail.leonidandand.soundlights.utils.Matrix;


public class ColorMatrixView extends FrameLayout {
    private static final int DEF_ROWS = 3;
    private static final int DEF_COLUMNS = 2;
    private static final int DEF_COLOR = Color.argb(35, 100, 150, 69);

    private int rows = DEF_ROWS;
    private int columns = DEF_COLUMNS;
    private int initColor = DEF_COLOR;
    private Context context;
    private Matrix<View> matrixElements;

    public ColorMatrixView(Context context) {
        super(context);
        init(context);
    }

    public ColorMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        processAttributes(context, attrs);
        init(context);
    }

    public ColorMatrixView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        processAttributes(context, attrs);
        init(context);
    }

    private void processAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(
                            attrs, R.styleable.ColorMatrixView);
        final int N = typedArray.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int index = typedArray.getIndex(i);
            switch (index)
            {
                case R.styleable.ColorMatrixView_rows:
                    this.rows = typedArray.getInt(index, DEF_ROWS);
                    break;

                case R.styleable.ColorMatrixView_columns:
                    this.columns = typedArray.getInt(index, DEF_COLUMNS);
                    break;

                case R.styleable.ColorMatrixView_initColor:
                    this.initColor = typedArray.getColor(index, DEF_COLOR);
                    break;
            }
        }
        typedArray.recycle();
    }

    private void init(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        LinearLayout verticalLayout = prepareLinearLayout(LinearLayout.VERTICAL);
        matrixElements = new Matrix<View>(rows, columns);
        for (int row = 0; row < rows; ++row) {
            LinearLayout rowLayout = prepareLinearLayout(LinearLayout.HORIZONTAL);
            for (int column = 0; column < columns; ++column) {
                View element = prepareColorMatrixElement();
                rowLayout.addView(element);
                matrixElements.set(new Matrix.Position(row, column), element);
            }
            verticalLayout.addView(rowLayout);
        }
        addView(verticalLayout);
    }

    private LinearLayout prepareLinearLayout(int orientation) {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(orientation);
        addParams(layout);
        return layout;
    }

    private View prepareColorMatrixElement() {
        View tableElement = new ImageView(context);
        addParams(tableElement);
        tableElement.setBackgroundColor(initColor);
        return tableElement;
    }

    private void addParams(View view) {
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f);
        view.setLayoutParams(param);
    }

    public void setColor(Matrix.Position pos, int color) {
        setColor(pos.row, pos.column, color);
    }

    public void setColor(int row, int column, int color) {
        View element = matrixElements.get(row, column);
        element.setBackgroundColor(color);
    }

    public Dimension getDimension() {
        return new Dimension(rows, columns);
    }
}
