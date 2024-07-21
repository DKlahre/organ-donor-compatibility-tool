
The Organ Transplant Compatibility Tool matches transplant candidates
with potential organ donors by parsing through an organ HLA epitope 
registry on 4 levels.

Category I - ORGAN
Pancreas
Heart
Lung
Kidney
Liver

Category II - BLOOD TYPE
TYPE O blood matches TYPE O, A, B, AB
TYPE A blood matches TYPE A, AB
TYPE B blood matches TYPE B, AB
TYPE AB blood matches TYPE AB

Category III - DONOR REGISTRY / HLA EPITOPE REGISTRY EPLET MATCHING
Don/Ep matching allows doctor to choose purity of possible eplet
data sets. Existence of polymorphic residue may be acceptable for
one organ transplant but not another.

Example:
84DEAV -> 84DEAV  //perfect match
84DEAV -> 85E  //polymorphic residue(85E) in question
84DEAV -> 86A  //polymorphic residue(86A) in question

Category IV - DONOR REGISTRY / TRANSPLANT CANDIDATE EPLET MATCHING
After level of acceptable polymorphic residue is decided, resulting
eplet datasets of donors are compared with dataset of transplant 
candidate.

Successful matches may be printed via PDF format and saved for
further review.

==============

Build Specs:
SDK - Amazon Corretto version 17.0.6
JavaFX Version: 17.0.6
JavaFX Runtime Version: 17.0.6+3

