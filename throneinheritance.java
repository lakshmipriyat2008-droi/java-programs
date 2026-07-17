public class ThroneInheritance {

    HashMap<String, ArrayList<String>> map = new HashMap<>();
    HashSet<String> dead = new HashSet<>();
    String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        map.putIfAbsent(parentName, new ArrayList<>());
        map.get(parentName).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        dfs(king, ans);
        return ans;
    }

    private void dfs(String person, List<String> ans) {
        if (!dead.contains(person))
            ans.add(person);

        if (map.containsKey(person)) {
            for (String child : map.get(person))
                dfs(child, ans);
        }
    }
}