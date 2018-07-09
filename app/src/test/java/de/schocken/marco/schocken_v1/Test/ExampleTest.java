package de.schocken.marco.schocken_v1.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import de.schocken.marco.schocken_v1.test.Delegate;
import de.schocken.marco.schocken_v1.test.Example;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ExampleTest {

    @Mock
    Delegate delegateMock;

    @InjectMocks
    Example example;

    @Test
    public void testDoIt() {
        example.doIt();

        verify(delegateMock).execute();
    }
}
