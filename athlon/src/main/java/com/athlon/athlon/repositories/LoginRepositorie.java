package com.athlon.athlon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.athlon.athlon.models.Login;

public interface LoginRepositorie  extends JpaRepository <Login, Long> {

}
