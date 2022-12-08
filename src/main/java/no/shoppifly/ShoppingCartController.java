package no.shoppifly;


import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
public class ShoppingCartController implements ApplicationListener<ApplicationReadyEvent> {


    private Map<String, Cart> theCart = new HashMap();

    private MeterRegistry meterRegistry;

    @Autowired
    public ShoppingCartController(MeterRegistry meterRegistry, CartService cartService) {
        this.cartService = cartService;
        this.meterRegistry = meterRegistry;
    }

    @Autowired
    private final CartService cartService;

    public ShoppingCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "/cart/{id}")
    public Cart getCart(@PathVariable String id) {
        theCart.get(id);
        return cartService.getCart(id);
    }

    /**
     * Checks out a shopping cart. Removes the cart, and returns an order ID
     *
     * @return an order ID
     */
    @PostMapping(path = "/cart/checkout")
    public String checkout(@RequestBody Cart cart) {
        theCart.remove(cart.getId());
        return cartService.checkout(cart);
    }

    /**
     * Updates a shopping cart, replacing it's contents if it already exists. If no cart exists (id is null)
     * a new cart is created.
     *
     * @return the updated cart
     */
    @PostMapping(path = "/cart")
    public Cart updateCart(@RequestBody Cart cart) {

        return cartService.update(cart);
    }

    /**
     * return all cart IDs
     *
     * @return
     */
    @GetMapping(path = "/carts")
    public List<String> getAllCarts() {
        theCart.keySet();
        return cartService.getAllsCarts();
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        // Verdi av total
        Gauge.builder("cart_count", theCart,
                b -> b.values().size()).register(meterRegistry);

        // Denne meter-typen "Gauge" rapporterer hvor mye penger som totalt finnes i carten
        Gauge.builder("cart_sum", theCart,
                            b -> b
                            .values()
                            .stream()
                            .flatMap(c -> c.getItems().stream()
                            .map(i -> i.getUnitPrice() * i.getQty()))
                            .reduce(0f, Float::sum))
                .register(meterRegistry);
    }
    

}