import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class LanguageMap {

    private String myLanguage;
    private Scanner s;
    private Map langMap = new Map() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Object get(Object key) {
            return null;
        }

        @Override
        public Object put(Object key, Object value) {
            return null;
        }

        @Override
        public Object remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set keySet() {
            return null;
        }

        @Override
        public Collection values() {
            return null;
        }

        @Override
        public Set<Entry> entrySet() {
            return null;
        }
    };

    // pplea --> aelpp <-- apple

    // this needs a Map that maps keys ex:  "aehr" to the
    // Set of String { "hare", "hear", "rhea"} that have those chars


    public LanguageMap(String lang, Scanner wordSource) {
        this.myLanguage = lang;

        // more...
    }

    public String getLanguage() {
        return myLanguage;
    }

}
