(function () {
    var btn = document.getElementById("theme-toggle");
    if (!btn) return;

    var root = document.documentElement;
    var mql = window.matchMedia("(prefers-color-scheme: dark)");

    function currentTheme() {
        var stored = localStorage.getItem("theme");
        if (stored === "light" || stored === "dark") return stored;
        return mql.matches ? "dark" : "light";
    }

    function applyIcon(theme) {
        btn.textContent = theme === "dark" ? "☀️" : "🌙";
        btn.setAttribute(
            "aria-label",
            theme === "dark" ? "Switch to light mode" : "Switch to dark mode"
        );
    }

    applyIcon(currentTheme());

    btn.addEventListener("click", function () {
        var next = currentTheme() === "dark" ? "light" : "dark";
        localStorage.setItem("theme", next);
        root.setAttribute("data-theme", next);
        applyIcon(next);
    });

    // Follow the system if the user hasn't made an explicit choice yet.
    mql.addEventListener("change", function () {
        if (!localStorage.getItem("theme")) {
            applyIcon(currentTheme());
        }
    });
})();
