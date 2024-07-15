window.addEventListener('load', function() {
  submitEvent();
})

const submitEvent = function() {
  // カスタムブートストラップ検証スタイルを適用するすべてのフォームを取得
    const forms = document.querySelectorAll('.needs-validation');
    // ループして帰順を防ぐ
     Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
      }

      form.classList.add('was-validated');
    }, false);
    });
}