package byc.avt.avanteeborrower.usecase;

public abstract class BaseUseCase<T> {
    protected T view;

    public BaseUseCase(T view){
        this.view = view;
    }

    public void doClear(){

    }
}
