package basePackage.objectModel;

import basePackage.exeptions.NotCorrectNameExeption;
import basePackage.exeptions.NotFoundNameException;

import javax.xml.bind.annotation.XmlAttribute;

public class Action implements IAction {
    private static int count = 0;
    @XmlAttribute
    private String actionName;
    @XmlAttribute
    private int id;

    public Action() {
    }

    public Action(String NameAction) {
        try {
            setActionName(NameAction);
            id = ++count;
        } catch (NotCorrectNameExeption e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getActionName() {
        return actionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return actionName == action.actionName;
    }

    public void setActionName(String actionName) throws NotCorrectNameExeption {
        try {
            if (actionName == null) {
                throw new NotFoundNameException();
            } else {
                if (actionName.matches("[a-zA-ZА-Яа-я]") || actionName.length() == 0) {
                    throw new NotCorrectNameExeption();
                }
            }
        } catch (NotFoundNameException e) {
            e.printStackTrace();
        }
        this.actionName = actionName;
    }
    @Override
    public String toString() {
        return getActionName();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return PRIME * id;
    }
}