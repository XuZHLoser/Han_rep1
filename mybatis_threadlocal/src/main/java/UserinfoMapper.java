import entity.Userinfo;

import java.util.List;

public interface UserinfoMapper {
    public void insert(Userinfo userinfo);
    public void deleteById(long id);
    public void updateById(Userinfo userinfo);
    public List<Userinfo> selectAll();
    public Userinfo selectById(long id);
}
