
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mercado Pago</title>
    </head>
    <body>
        <script src="https://sdk.mercadopago.com/js/v2"></script>
        <script type="text/javascript">
            const mp = new MercadoPago('TEST-09a70fb6-6b5b-48c1-8d54-8cb2ba22e99d', {
                locale: 'es-AR'
            });

            // Inicializa el checkout
            const checkout = mp.checkout({
                preference: {
                    id: '${idPreferencia}'
                },
                autoOpen: true,        
            });
        </script>
    </body>
</html>
