package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * model.User: yzh
 * Date: 2022-06-27
 * Time: 19:31
 */
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    //获取数据库的博客列表
    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先尝试从req中获取blogId的参数，如果该参数存在，说明是要请求博客详情.
        //如果参数不存在,说明请求博客的列表
        BlogDao blogDao=new BlogDao();
        resp.setContentType("application/json;charset=utf8");
        String param=req.getParameter("blogId");
        if(param==null){
            //说明不存在参数我们获取博客列表
            //从数据库中查询到博客列表转成Json格式返回
            List<Blog> blogs=blogDao.selectAll();
            //blogs对象转成Json模式
            String respJson=objectMapper.writeValueAsString(blogs);
            resp.getWriter().write(respJson);
        }else{
            //存在参数获取博客详情
            int blogId=Integer.parseInt(param);
            Blog blog=blogDao.selectOne(blogId);
            String respJson= objectMapper.writeValueAsString(blog);
            resp.getWriter().write(respJson);

        }

    }
}
