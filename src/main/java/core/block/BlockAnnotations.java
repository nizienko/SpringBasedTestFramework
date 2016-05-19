package core.block;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.Annotations;

import java.lang.reflect.Field;

/**
 * Created by nizienko on 19.05.2016.
 */
public class BlockAnnotations extends Annotations {
    public BlockAnnotations(Field field) {
        super(field);
    }

    public By buildBy() {
        this.assertValidAnnotations();
        By ans = null;
        FindBys findBys = (FindBys)super.getField().getAnnotation(FindBys.class);
        if(findBys != null) {
            ans = this.buildByFromFindBys(findBys);
        }

        FindAll findAll = (FindAll)super.getField().getAnnotation(FindAll.class);
        if(ans == null && findAll != null) {
            ans = this.buildBysFromFindByOneOf(findAll);
        }

        FindBy findBy = (FindBy)super.getField().getAnnotation(FindBy.class);
        if(ans == null && findBy != null) {
            ans = this.buildByFromFindBy(findBy);
        }

        FindBy blockFindBy = (FindBy)super.getField().getType().getAnnotation(FindBy.class);
        if (ans == null && blockFindBy != null) {
            ans = this.buildByFromFindBy(blockFindBy);
        }

        if(ans == null) {
            ans = this.buildByFromDefault();
        }

        if(ans == null) {
            throw new IllegalArgumentException("Cannot determine how to locate element " + super.getField());
        } else {
            return ans;
        }
    }
}
