import { useErrorBoundary } from "use-error-boundary";
import { useEffect, useState } from "react";

export default function ErrorBoundryEx() {
  const [counter, setCounter] = useState(0);

  const fallback = (
    <div>
      <h1>Oops! Something went wrong.</h1>
      <button onClick={() => window.location.reload()}>Reload</button>
    </div>
  );

  const [hasError, resetErrorBoundary] = useErrorBoundary();

  useEffect(() => {
    if (counter > 5) {
      throw new Error("Counter limit exceeded");
    }
  }, [counter]);

  return (
    <>
      {hasError ? (
        fallback
      ) : (
        <div>
          <h1>Counter: {counter}</h1>
          <button onClick={() => setCounter(counter + 1)}>Increment</button>
        </div>
      )}
    </>
  );
}
