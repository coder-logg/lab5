package basePackage.objectModel;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Class save humans on <code>Vector<Human></code>.
 *
 * @see Human
 */
@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Humans {
    @XmlElement(name = "human")
    private CopyOnWriteArrayList<Human> humans;
}
