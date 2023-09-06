package postgre.create.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Page {
    private int pageNum;
    private int amount;

    public Page(){
        this(1, 10);
    }

    public Page(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
}
