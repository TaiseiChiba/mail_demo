package web;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.SystemException;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/front-controller")
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pathの指定
        final String path = "/WEB-INF/jsp/";
        String page = null;

        // ボタンIDの取得
        request.setCharacterEncoding("UTF-8");
        String buttonId = request.getParameter("buttonId");

        // パラメータ未送信または空文buttonId == nul字の場合
        if (Objects.isNull(buttonId) || buttonId.equals("")) {
            // ログイン画面のbuttonIdをデフォルトとして設定する
            buttonId = "uc001_01";
        }

        // アクション呼び出し
        page = execute(request, buttonId);

        // 結果画面に転送
        final RequestDispatcher rd = request.getRequestDispatcher(path + page);
        rd.forward(request, response);
    }

    /**
     * アクションを呼び出します。
     *
     * @param request  リクエスト
     * @param buttonId ボタンID
     * @return 画面遷移先ファイル
     */
    private String execute(HttpServletRequest request, String buttonId) {

        ActionIF action = null;

        try {
            switch (buttonId) {
            // 検索画面
            case "uc001_01":
                return "loginForm.jsp";
            // 検索結果画面
            case "uc001_02":
                action = new LoginAction();
                return action.execute(request);
            case "uc002_01":
                action = new MailAction();
                return action.execute(request);
            default:
                // buttonIdが存在しない場合
                return "未定.jsp";
            }
        } catch (final SystemException e) {
            return "system-error-page.jsp";
        }
    }

    /**
     * セッションチェックを行います。
     *
     * @param request リクエスト
     * @throws SalesSystemException セッションエラーの場合、例外
     */
    private void checkSession(HttpServletRequest request) throws SystemException {
        final HttpSession session = request.getSession(false);
        // セッションが存在しない
        // TODO セッションの処理を追加したら、sessionのnullチェックを行う。
        // TODO ユーザーのnullチェック
        if (false) {
            throw new SystemException("ページの有効期限がきれました。ログインしてください。");
        }
    }


}
