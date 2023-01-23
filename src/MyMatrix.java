import java.util.Vector;

public class MyMatrix {
    private MyComplex[][] matrix_ = null;
    private int h_ = 0, w_ = 0;

    public MyMatrix(int h, int w) {
        matrix_ = new MyComplex[h][w];
        h_ = h;
        w_ = w;
    }

    public void add(MyMatrix m) {
        for (int row = 0; row < h_; ++row) {
            for (int col = 0; col < w_; ++col) {
                matrix_[row][col].add(m.matrix_[row][col]);
            }
        }
    }

    public void mult(MyComplex cmplx) {
        for (int row = 0; row < h_; ++row) {
            for (int col = 0; col < w_; ++col) {
                matrix_[row][col].mult(cmplx);
            }
        }
    }

    public void mult(MyMatrix m) {
        if (h_ != m.w_ || w_ != m.h_) {
            System.out.print("Invalid multiply operands\n");
            return;
        }

        MyComplex[][] new_m = new MyComplex[h_][m.w_];
        for (int row = 0; row < h_; ++row) {
            for (int col = 0; col < m.w_; ++col) {
                MyComplex c = new MyComplex(0, 0);
                for (int k = 0; k < m.h_; ++k) {
                    MyComplex tmp = new MyComplex(0, 0);
                    tmp.add(matrix_[row][k]);
                    tmp.mult(m.matrix_[k][col]);
                    c.add(tmp);
                }
                new_m[row][col] = c;
            }
        }

        matrix_ = new_m;
    }

    public MyMatrix transpose() {
        MyMatrix result = new MyMatrix(w_, h_);

        for (int row = 0; row < h_; ++row) {
            for (int col = 0; col < h_; ++col) {
                result.matrix_[col][row] = matrix_[row][col];
            }
        }
        return result;
    }
}
