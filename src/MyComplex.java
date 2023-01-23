
public class MyComplex {
    private int real_;
    private int imaginary_;

    public MyComplex() {
        real_ = 0;
        imaginary_ = 0;
    }

    public MyComplex(int real, int imaginary) {
        real_ = real;
        imaginary_ = imaginary;
    }

    public int getReal_() {
        return real_;
    }

    public int getImaginary_() {
        return imaginary_;
    }

    public void add(MyComplex cmplx) {
        real_ += cmplx.real_;
        imaginary_ += cmplx.imaginary_;
    }

    public void mult(MyComplex cmplx) {
        real_ = real_ * cmplx.real_ - imaginary_ * cmplx.imaginary_;
        imaginary_ = real_ * cmplx.imaginary_ + cmplx.real_ * imaginary_;
    }

    public void divide(MyComplex cmplx) {
        int denominator = (cmplx.real_ * cmplx.real_ + cmplx.imaginary_ * cmplx.imaginary_);
        real_ = (real_ * cmplx.real_ + imaginary_ * cmplx.imaginary_) / denominator;
        imaginary_ = (imaginary_ * cmplx.real_ - real_ * cmplx.imaginary_) / denominator;
    }
}
