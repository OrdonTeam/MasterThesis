cd paper
mkdir build
pdflatex -interaction=nonstopmode -halt-on-error -output-directory build main.tex
cd ..
open paper/build/main.pdf