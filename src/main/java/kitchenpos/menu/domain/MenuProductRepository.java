package kitchenpos.menu.domain;

import kitchenpos.menu.domain.MenuProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuProductRepository extends JpaRepository<MenuProduct, Long> {
}