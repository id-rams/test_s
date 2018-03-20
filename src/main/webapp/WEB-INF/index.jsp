<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>

    <!-- Basic Page Needs
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <meta charset="utf-8">
    <title>Your page title here :)</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Mobile Specific Metas
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- FONT
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

    <!-- CSS
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link rel="stylesheet" href="/css/normalize.css">
    <link rel="stylesheet" href="/css/skeleton.css">
   <link rel="stylesheet" href="/css/vanillaCalendar.css" >
    <!-- Favicon
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link rel="icon" type="image/png" href="/images/favicon.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<div class="container">
    <div class="docs-section" id="forms">

        <form id = "create_order_form">
            <div class="row">
                <div class="eight columns">
                    <label for="name">Ваше имя</label>
                    <input class="u-full-width" type="text" placeholder="name" id="name">
                </div>
                <div class="eight columns">
                    <label for="phone">Номер телефона</label>
                    <input class="u-full-width" type="text" placeholder="+380884365885" id="phone">
                </div>
                <div class="eight columns">
                    <label for="v-cal">Время и дата</label>


                    <p class="demo-picked">
                    			Дата:
                    			<span data-calendar-label="picked" id="time"></span>
                    		</p>
                </div>
                <div class="eight columns">
                    <label for="email">Ваш емейл</label>
                    <input class="u-full-width" type="text" placeholder="doe@gmail.com" id="email">
                </div>
                <div class="eight columns">
                    <label for="service">Выбирите услугу</label>
                    <select class="u-full-width" id="service">
                        <option value="order_1">Корекция бровей</option>
                        <option value="order_2">Покраска бровей</option>
                        <option value="order_3">Макиаж</option>
                    </select>
                </div>
                <div class="eight columns">
                    <input class="button-primary" type="submit" value="Записаться" id="create_order">
                </div>
            </div>
        </form>
        <form id = "confirm_order_form">
            <div class="row">
                <div class="eight columns">
                    <label for="code">Проверочный код с смс</label>
                    <input class="u-full-width" type="text" placeholder="code" id="code">
                </div>

                </div>
                <div class="eight columns">
                    <input class="button-primary" type="submit" value="Подвердить запись" id="confirm_order">
                </div>

        </form>

    </div>
</div>
<script src="/js/vanillaCalendar.js" type="text/javascript"></script>
	<script>
		window.addEventListener('load', function () {
			vanillaCalendar.init({
				disablePastDays: true
			});
		})
	</script>
<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>
