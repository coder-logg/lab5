package basePackage.objectModel;

import basePackage.exeptions.NotCorrectNameExeption;
import basePackage.exeptions.NotFoundNameException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Profession implements IProfession {
    private static int count = 0;
    @XmlAttribute
    private String professionName;
    @XmlAttribute
    private int id;

    public Profession() {
    }

    public Profession(String professionName) {
        try {
            if (professionName == null) throw new NotFoundNameException();
        } catch (NotFoundNameException e) {
            e.printStackTrace();
        }
        this.professionName = professionName;
        id = ++count;
    }

    @Override
    public String getProfession() {
        if (professionName == null || professionName.matches("[a-zA-ZА-Яа-я]") || professionName.length() == 0) {
            return "Unemployed";
        } else {
            return professionName;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profession profession = (Profession) o;
        return professionName.equals(profession.professionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professionName, id);
    }

    @Override
    public String toString() {
        return getProfession();
    }

    public static class Education {
        private String speciality;

        Education(String speciality) {
            this.speciality = speciality;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public void EducationLevel(String educationLevel) {
            class LevelsEducation {
                private String typeEducation;
                private Set<String> a = Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList("Secondary general education ","Full secondary ","Higher ")));

                LevelsEducation(String typeEducation) {
                    this.typeEducation = typeEducation;
                    if (!a.contains(typeEducation)) throw new NotCorrectNameExeption(typeEducation, "Education can be only of three types: \"General secondary\", \"Full secondary\", \"Higher\"");;
                }


            }
            LevelsEducation myEducationLevel = new LevelsEducation(educationLevel){
                @Override
                public String toString(){
                return super.typeEducation+"education";
                }
            };
        }
    }

}
