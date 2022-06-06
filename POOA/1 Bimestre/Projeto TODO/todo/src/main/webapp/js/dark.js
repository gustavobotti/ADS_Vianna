let mode = document.querySelector("input[type=checkbox]")
            mode.onclick = (e) => {
                //console.log(e.target.checked);
                let list = document.querySelectorAll(".header, .footer") 
                list.forEach(e => { e.classList.toggle("dark-theme") })
                list = document.querySelectorAll(".main, .board") 
                list.forEach(e => { e.classList.toggle("dark-theme-main") })
                let logo = document.querySelector(".header img")
                logo.src = (!e.target.checked)? "/img/logo.svg": "/img/logoBlack.svg";
                let btn = document.querySelector(".iconFab")
                btn.classList.toggle("dark-theme-btn")
                //if (e.target.checked) {
                //} else {
                    
                //}
            }

