package in.sudopk.vaishnavacalendar;

import com.google.gson.FieldNamingStrategy;

import java.lang.reflect.Field;

public class RemoveFieldNameStrategy implements FieldNamingStrategy {
    @Override
    public String translateName(final Field f) {
        char[] name = f.getName().toCharArray();
        int offset = 0;
        if(name.length >= 2) {
            name[1] = Character.toLowerCase(name[1]);
            offset = 1;
        }
        return new String(name, offset, name.length - offset);
    }
}
