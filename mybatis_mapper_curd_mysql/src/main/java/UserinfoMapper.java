import entity.Userinfo;

import java.util.List;

public interface UserinfoMapper {
    public void insertUserinfo(Userinfo userinfo);
    public Userinfo getUserinfoById(long Id);
    public List<Userinfo> getUserinfoByIds(long Id1, long Id2);
}
